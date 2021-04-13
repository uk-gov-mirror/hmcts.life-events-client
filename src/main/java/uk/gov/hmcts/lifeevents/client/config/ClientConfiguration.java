package uk.gov.hmcts.lifeevents.client.config;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.security.KeyManagementException;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Security;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

import feign.Client;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;

@EnableConfigurationProperties
public class ClientConfiguration {

  @Autowired
  ResourceOwnerPasswordResourceDetails resourceOwnerPasswordResourceDetails;

  @Bean
  public OAuth2FeignRequestInterceptor bearerTokenRequestInterceptor() {
    return new OAuth2FeignRequestInterceptor(new DefaultOAuth2ClientContext(), resourceOwnerPasswordResourceDetails);
  }

  @Bean
  public ResourceOwnerPasswordResourceDetails bearerTokenResourceDetails(
          @Value("${bearertoken.accessTokenUri}") String accessTokenUri,
          @Value("${bearertoken.clientId}") String clientId,
          @Value("${bearertoken.clientSecret}") String clientSecret,
          @Value("${bearertoken.username}") String userName,
          @Value("${bearertoken.password}") String password
          ) {
    ResourceOwnerPasswordResourceDetails details = new ResourceOwnerPasswordResourceDetails();
    details.setAccessTokenUri(accessTokenUri);
    details.setClientId(clientId);
    details.setClientSecret(clientSecret);
    details.setUsername(userName);
    details.setPassword(password);
    return details;
  }

  @Bean
  public Client levClient(
          @Value("${ssl.publicCertificate}") String publicCertificate,
          @Value("${ssl.privateKey}") String privateKey
  )
          throws NoSuchAlgorithmException, KeyStoreException,
          CertificateException, IOException, KeyManagementException, UnrecoverableKeyException {

    return new Client.Default(getClientSSLSocketFactory(publicCertificate, privateKey), null);
  }

  private SSLSocketFactory getClientSSLSocketFactory(String publicCertificate, String privateKey)
          throws NoSuchAlgorithmException, KeyStoreException,
          CertificateException, IOException, KeyManagementException, UnrecoverableKeyException
  {

    SSLContext sslContext = SSLContext.getInstance("TLS");

    KeyStore kStore = KeyStore.getInstance(KeyStore.getDefaultType());

    CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");

    InputStream is = new ByteArrayInputStream(publicCertificate.getBytes());
    X509Certificate certificate = (X509Certificate) certificateFactory.generateCertificate(is);


    PEMParser pemParser = new PEMParser(new StringReader(privateKey));
    Security.addProvider(new BouncyCastleProvider());
    JcaPEMKeyConverter converter = new JcaPEMKeyConverter().setProvider("BC");
    Object object = pemParser.readObject();
    KeyPair kp = converter.getKeyPair((PEMKeyPair) object);
    PrivateKey key = kp.getPrivate();

    kStore.load(null);
    kStore.setKeyEntry("alias", key, null, new java.security.cert.Certificate[]{certificate});

    KeyManagerFactory kmf = KeyManagerFactory
            .getInstance(KeyManagerFactory.getDefaultAlgorithm());
    kmf.init(kStore, null);
    KeyManager[] keyManagers = kmf.getKeyManagers();

    if (keyManagers == null) {
      keyManagers = new KeyManager[]{};
    }

    sslContext.init(keyManagers, null, null);

    return sslContext.getSocketFactory();
  }
}
