import uk.gov.hmcts.lifeevents.client.api.DeathApiClient;
import uk.gov.hmcts.lifeevents.client.config.ClientConfiguration;
import uk.gov.hmcts.lifeevents.client.config.ServiceConfiguration;
import uk.gov.hmcts.lifeevents.client.service.DeathService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@EnableAutoConfiguration
@ExtendWith(SpringExtension.class)
@SpringBootTest(
        classes = { ClientConfiguration.class, ServiceConfiguration.class }
)
@EnableConfigurationProperties
@ContextConfiguration()
public class AutoConfigurationTest {

    @Autowired
    private ApplicationContext context;

    @DisplayName("Should have Api configured")
    @Test
    public void haveApi() {
        assertThat(context.getBeanNamesForType(DeathApiClient.class)).hasSize(1);
        assertThat(context.getBeanNamesForType(DeathService.class)).hasSize(1);
    }
}
