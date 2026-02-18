package com.vineshotel.service;

import java.util.List;

import com.vineshotel.entity.Room;

public interface RoomService {
	 List<Room> getAllRooms();

	    void saveRoom(Room room);

	    void deleteRoom(Long id);

	    Room getRoomById(Long id);
}
