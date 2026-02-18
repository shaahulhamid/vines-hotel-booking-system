package com.vineshotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vineshotel.entity.Room;
import com.vineshotel.repository.RoomRepository;

public class RoomServiceImpl implements RoomService{
	@Autowired
    private RoomRepository roomRepo;

    @Override
    public List<Room> getAllRooms() {
        return roomRepo.findAll();
    }

    @Override
    public void saveRoom(Room room) {
        roomRepo.save(room);
    }

    @Override
    public void deleteRoom(Long id) {
        roomRepo.deleteById(id);
    }

    @Override
    public Room getRoomById(Long id) {
        return roomRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));
    }
}
