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
 * Location that the event happened at
 */
@ApiModel(description = "Location that the event happened at")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-02T13:36:51.963195Z[Europe/London]")

public class Location   {
  @JsonProperty("name")
  private String name;

  @JsonProperty("nameQualifier")
  private String nameQualifier;

  @JsonProperty("registrationDistrict")
  private String registrationDistrict;

  @JsonProperty("subDistrict")
  private String subDistrict;

  @JsonProperty("administrativeArea")
  private String administrativeArea;

  public Location name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name
   * @return name
  */
  @ApiModelProperty(example = "Manchester, Manchester, Metropolitan District of Manchester", value = "Name")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Location nameQualifier(String nameQualifier) {
    this.nameQualifier = nameQualifier;
    return this;
  }

  /**
   * Name qualifier
   * @return nameQualifier
  */
  @ApiModelProperty(example = "generated by concatenating registrationDistrict, subDistrict and administrativeArea", value = "Name qualifier")


  public String getNameQualifier() {
    return nameQualifier;
  }

  public void setNameQualifier(String nameQualifier) {
    this.nameQualifier = nameQualifier;
  }

  public Location registrationDistrict(String registrationDistrict) {
    this.registrationDistrict = registrationDistrict;
    return this;
  }

  /**
   * Registration district
   * @return registrationDistrict
  */
  @ApiModelProperty(example = "Manchester", value = "Registration district")


  public String getRegistrationDistrict() {
    return registrationDistrict;
  }

  public void setRegistrationDistrict(String registrationDistrict) {
    this.registrationDistrict = registrationDistrict;
  }

  public Location subDistrict(String subDistrict) {
    this.subDistrict = subDistrict;
    return this;
  }

  /**
   * Sub-district
   * @return subDistrict
  */
  @ApiModelProperty(example = "Manchester", value = "Sub-district")


  public String getSubDistrict() {
    return subDistrict;
  }

  public void setSubDistrict(String subDistrict) {
    this.subDistrict = subDistrict;
  }

  public Location administrativeArea(String administrativeArea) {
    this.administrativeArea = administrativeArea;
    return this;
  }

  /**
   * Administrative area
   * @return administrativeArea
  */
  @ApiModelProperty(example = "Metropolitan District of Manchester", value = "Administrative area")


  public String getAdministrativeArea() {
    return administrativeArea;
  }

  public void setAdministrativeArea(String administrativeArea) {
    this.administrativeArea = administrativeArea;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Location location = (Location) o;
    return Objects.equals(this.name, location.name) &&
        Objects.equals(this.nameQualifier, location.nameQualifier) &&
        Objects.equals(this.registrationDistrict, location.registrationDistrict) &&
        Objects.equals(this.subDistrict, location.subDistrict) &&
        Objects.equals(this.administrativeArea, location.administrativeArea);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, nameQualifier, registrationDistrict, subDistrict, administrativeArea);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Location {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    nameQualifier: ").append(toIndentedString(nameQualifier)).append("\n");
    sb.append("    registrationDistrict: ").append(toIndentedString(registrationDistrict)).append("\n");
    sb.append("    subDistrict: ").append(toIndentedString(subDistrict)).append("\n");
    sb.append("    administrativeArea: ").append(toIndentedString(administrativeArea)).append("\n");
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

