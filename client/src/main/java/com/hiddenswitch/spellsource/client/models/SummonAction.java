/*
 * Hidden Switch Spellsource API
 * The Spellsource API for matchmaking, user accounts, collections management and more.  To get started, create a user account and make sure to include the entirety of the returned login token as the X-Auth-Token header. You can reuse this token, or login for a new one.  ClientToServerMessage and ServerToClientMessage are used for the realtime game state and actions two-way websocket interface for actually playing a game. Envelope is used for the realtime API services. 
 *
 * OpenAPI spec version: 2.1.0
 * Contact: ben@hiddenswitch.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.hiddenswitch.spellsource.client.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.hiddenswitch.spellsource.client.models.SummonActionIndexToActions;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * A summon action that originates from a specific card. 
 */
@ApiModel(description = "A summon action that originates from a specific card. ")
@JsonInclude(JsonInclude.Include.NON_DEFAULT)

public class SummonAction implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("sourceId")
  private Integer sourceId = null;

  @JsonProperty("indexToActions")
  private List<SummonActionIndexToActions> indexToActions = null;

  public SummonAction sourceId(Integer sourceId) {
    this.sourceId = sourceId;
    return this;
  }

   /**
   * The ID of the source card in your hand. 
   * @return sourceId
  **/
  @ApiModelProperty(value = "The ID of the source card in your hand. ")
  public Integer getSourceId() {
    return sourceId;
  }

  public void setSourceId(Integer sourceId) {
    this.sourceId = sourceId;
  }

  public SummonAction indexToActions(List<SummonActionIndexToActions> indexToActions) {
    this.indexToActions = indexToActions;
    return this;
  }

  public SummonAction addIndexToActionsItem(SummonActionIndexToActions indexToActionsItem) {
    if (this.indexToActions == null) {
      this.indexToActions = new ArrayList<>();
    }
    this.indexToActions.add(indexToActionsItem);
    return this;
  }

   /**
   * An array of index-action pairs that let you convert a battlefield location to an action index to respond with. 
   * @return indexToActions
  **/
  @ApiModelProperty(value = "An array of index-action pairs that let you convert a battlefield location to an action index to respond with. ")
  public List<SummonActionIndexToActions> getIndexToActions() {
    return indexToActions;
  }

  public void setIndexToActions(List<SummonActionIndexToActions> indexToActions) {
    this.indexToActions = indexToActions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SummonAction summonAction = (SummonAction) o;
    return Objects.equals(this.sourceId, summonAction.sourceId) &&
        Objects.equals(this.indexToActions, summonAction.indexToActions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sourceId, indexToActions);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SummonAction {\n");
    
    sb.append("    sourceId: ").append(toIndentedString(sourceId)).append("\n");
    sb.append("    indexToActions: ").append(toIndentedString(indexToActions)).append("\n");
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

