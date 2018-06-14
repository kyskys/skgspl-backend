package skgspl.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import skgspl.dao.api.AbstractDao;
import skgspl.dao.api.RoomDao;
import skgspl.entity.Room;
import skgspl.service.api.RoomService;

@Transactional
@Service
public class RoomServiceImpl extends AbstractServiceImpl<Room> implements RoomService{

	@Autowired
	RoomDao roomDao;
	
	@Override
	protected AbstractDao<Room> getDao() {
		return roomDao;
	}

}
