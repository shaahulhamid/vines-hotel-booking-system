package com.vineshotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vineshotel.entity.Room;
import com.vineshotel.repository.RoomRepository;

@Service
public class RoomService {
	@Autowired
	private  RoomRepository roomRepo;
	
	public List<Room> getAllRooms(){
		return roomRepo.findAll();
	}
	
	public void saveRoom(Room room) {
		roomRepo.save(room);
	}
	
	public void deleteRoom(Long id) {
		roomRepo.deleteById(id);
	}
	
	public Room getRoomById(Long id) {
		return roomRepo.findById(id).orElse(null);
	}
}
