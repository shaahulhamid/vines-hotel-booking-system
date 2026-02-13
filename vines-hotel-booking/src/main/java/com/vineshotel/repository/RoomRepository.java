package com.vineshotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vineshotel.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long>	{

}
