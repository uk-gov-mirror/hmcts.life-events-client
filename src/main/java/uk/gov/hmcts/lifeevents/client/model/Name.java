package uk.gov.hmcts.lifeevents.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Name of the person
 */
@ApiModel(description = "Name of the person")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-10T16:10:49.642712Z[Europe/London]")

public class Name   {
  @JsonProperty("givenName")
  private String givenName;

  @JsonProperty("surname")
  private String surname;

  @JsonProperty("fullName")
  private String fullName;

  @JsonProperty("qualifier")
  private String qualifier;

  public Name givenName(String givenName) {
    this.givenName = givenName;
    return this;
  }

  /**
   * Given name of the person
   * @return givenName
  */
  @ApiModelProperty(example = "Joan Narcissus Ouroboros", value = "Given name of the person")


  public String getGivenName() {
    return givenName;
  }

  public void setGivenName(String givenName) {
    this.givenName = givenName;
  }

  public Name surname(String surname) {
    this.surname = surname;
    return this;
  }

  /**
   * Surname of the person
   * @return surname
  */
  @ApiModelProperty(example = "Smith", value = "Surname of the person")


  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public Name fullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  /**
   * Full name of the person
   * @return fullName
  */
  @ApiModelProperty(example = "Joan Narcissus Ouroboros Smith", value = "Full name of the person")


  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public Name qualifier(String qualifier) {
    this.qualifier = qualifier;
    return this;
  }

  /**
   * Details about how the full name was made
   * @return qualifier
  */
  @ApiModelProperty(example = "generated from prepending forename to surname", value = "Details about how the full name was made")


  public String getQualifier() {
    return qualifier;
  }

  public void setQualifier(String qualifier) {
    this.qualifier = qualifier;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Name name = (Name) o;
    return Objects.equals(this.givenName, name.givenName) &&
        Objects.equals(this.surname, name.surname) &&
        Objects.equals(this.fullName, name.fullName) &&
        Objects.equals(this.qualifier, name.qualifier);
  }

  @Override
  public int hashCode() {
    return Objects.hash(givenName, surname, fullName, qualifier);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Name {\n");
    
    sb.append("    givenName: ").append(toIndentedString(givenName)).append("\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    fullName: ").append(toIndentedString(fullName)).append("\n");
    sb.append("    qualifier: ").append(toIndentedString(qualifier)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

