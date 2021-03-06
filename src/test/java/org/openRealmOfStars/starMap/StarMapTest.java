package org.openRealmOfStars.starMap;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.openRealmOfStars.player.PlayerInfo;
import org.openRealmOfStars.player.PlayerList;
import org.openRealmOfStars.player.SpaceRace.SpaceRace;
import org.openRealmOfStars.player.message.MessageList;
import org.openRealmOfStars.player.ship.ShipStat;

/**
 *
 * Open Realm of Stars game project
 * Copyright (C) 2016,2017 Tuomo Untinen
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see http://www.gnu.org/licenses/
 *
 *
 * Tests for StarMap
 *
 */
public class StarMapTest {

  @Test
  @Category(org.openRealmOfStars.UnitTest.class)
  public void testStarMapCreate() {
    GalaxyConfig config = Mockito.mock(GalaxyConfig.class);
    Mockito.when(config.getSizeX()).thenReturn(50);
    Mockito.when(config.getSizeY()).thenReturn(50);
    Mockito.when(config.getStartingPosition()).thenReturn(
        GalaxyConfig.START_POSITION_BORDER);

    PlayerList players = Mockito.mock(PlayerList.class);

    StarMap map = new StarMap(config, players);
    assertEquals(50, map.getMaxX());
    assertEquals(50, map.getMaxY());
    assertEquals(true, map.isValidCoordinate(25, 25));
    assertEquals(false, map.isValidCoordinate(-1, 25));
    assertEquals(false, map.isValidCoordinate(25, -1));
    assertEquals(false, map.isValidCoordinate(512, 25));
    assertEquals(false, map.isValidCoordinate(252, 512));
  }

  @Test
  @Category(org.openRealmOfStars.UnitTest.class)
  public void testStarMapCreateWithPlayers() {
    GalaxyConfig config = Mockito.mock(GalaxyConfig.class);
    Mockito.when(config.getSizeX()).thenReturn(50);
    Mockito.when(config.getSizeY()).thenReturn(50);
    Mockito.when(config.getMaxPlayers()).thenReturn(4);
    Mockito.when(config.getStartingPosition()).thenReturn(
        GalaxyConfig.START_POSITION_BORDER);

    PlayerInfo info = Mockito.mock(PlayerInfo.class);
    Mockito.when(info.getRace()).thenReturn(SpaceRace.HUMAN);
    Mockito.when(info.getEmpireName()).thenReturn("Empire of Human");
    MessageList msgList = Mockito.mock(MessageList.class);
    Mockito.when(info.getMsgList()).thenReturn(msgList);
    ShipStat[] stats = new ShipStat[0];
    Mockito.when(info.getShipStatList()).thenReturn(stats);
    
    PlayerList players = Mockito.mock(PlayerList.class);
    Mockito.when(players.getPlayerInfoByIndex(0)).thenReturn(info);
    Mockito.when(players.getPlayerInfoByIndex(1)).thenReturn(info);
    Mockito.when(players.getPlayerInfoByIndex(2)).thenReturn(info);
    Mockito.when(players.getPlayerInfoByIndex(3)).thenReturn(info);

    StarMap map = new StarMap(config, players);
    assertEquals(50, map.getMaxX());
    assertEquals(50, map.getMaxY());
    assertEquals(true, map.isValidCoordinate(25, 25));
    assertEquals(false, map.isValidCoordinate(-1, 25));
    assertEquals(false, map.isValidCoordinate(25, -1));
    assertEquals(false, map.isValidCoordinate(512, 25));
    assertEquals(false, map.isValidCoordinate(252, 512));
  }

  @Test
  @Category(org.openRealmOfStars.UnitTest.class)
  public void testStarMapCreateWithPlayers2() {
    GalaxyConfig config = Mockito.mock(GalaxyConfig.class);
    Mockito.when(config.getSizeX()).thenReturn(75);
    Mockito.when(config.getSizeY()).thenReturn(75);
    Mockito.when(config.getMaxPlayers()).thenReturn(4);
    Mockito.when(config.getStartingPosition()).thenReturn(
        GalaxyConfig.START_POSITION_RANDOM);

    PlayerInfo info = Mockito.mock(PlayerInfo.class);
    Mockito.when(info.getRace()).thenReturn(SpaceRace.HUMAN);
    Mockito.when(info.getEmpireName()).thenReturn("Empire of Human");
    MessageList msgList = Mockito.mock(MessageList.class);
    Mockito.when(info.getMsgList()).thenReturn(msgList);
    ShipStat[] stats = new ShipStat[0];
    Mockito.when(info.getShipStatList()).thenReturn(stats);
    
    PlayerList players = Mockito.mock(PlayerList.class);
    Mockito.when(players.getPlayerInfoByIndex(0)).thenReturn(info);
    Mockito.when(players.getPlayerInfoByIndex(1)).thenReturn(info);
    Mockito.when(players.getPlayerInfoByIndex(2)).thenReturn(info);
    Mockito.when(players.getPlayerInfoByIndex(3)).thenReturn(info);


    StarMap map = new StarMap(config, players);
    assertEquals(75, map.getMaxX());
    assertEquals(75, map.getMaxY());
    assertEquals(true, map.isValidCoordinate(25, 25));
    assertEquals(false, map.isValidCoordinate(-1, 25));
    assertEquals(false, map.isValidCoordinate(25, -1));
    assertEquals(false, map.isValidCoordinate(512, 25));
    assertEquals(false, map.isValidCoordinate(252, 512));
  }

}
