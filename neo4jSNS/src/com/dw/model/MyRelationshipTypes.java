package com.dw.model;

import org.neo4j.graphdb.RelationshipType;

/**
 * @author DY1101shaoyuxian
 */
public enum MyRelationshipTypes implements RelationshipType {
    IS_FRIEND_OF,
    PUBLISH,
    COMMENT,
    MANAGER;
    //PRAISE;
}