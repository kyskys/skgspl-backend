package skgspl.dao.impl;

import org.springframework.stereotype.Repository;

import skgspl.dao.api.RoomDao;
import skgspl.entity.Room;

@Repository
public class RoomDaoImpl extends AbstractDaoImpl<Room> implements RoomDao{

	@Override
	public Class<Room> getGenericClass() {
		return Room.class;
	}

}
