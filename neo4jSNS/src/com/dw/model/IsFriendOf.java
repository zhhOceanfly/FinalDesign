package com.dw.model;

import org.neo4j.graphdb.RelationshipType;

/**
 * @author DY1101shaoyuxian
 */
public class IsFriendOf implements RelationshipType {

    public static final String IS_FRIEND_OF = "IS_FRIEND_OF";

    public String name() {
        return IS_FRIEND_OF;
    }
}