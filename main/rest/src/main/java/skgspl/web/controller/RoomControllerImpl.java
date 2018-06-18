package skgspl.web.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import skgspl.dao.search.GroupSearchParams;
import skgspl.dao.search.SortParam;
import skgspl.dto.group.GroupCreateDto;
import skgspl.dto.group.GroupDto;
import skgspl.dto.group.GroupGetDto;
import skgspl.entity.Group;
import skgspl.entity.util.DictionaryItem;
import skgspl.service.api.GroupService;
import skgspl.service.api.RoomService;
import skgspl.service.api.UserService;

@RestController
@RequestMapping("/api/room/")
public class RoomControllerImpl {

	@Autowired
	RoomService roomService;
	// @Autowired
	// UserService userService;

	// @RequestMapping(value = "{id}", method = RequestMethod.GET, produces =
	// "application/json")
	// public GroupGetDto getGroup(@PathVariable("id") Long id) {
	// return new GroupGetDto(groupService.get(id));
	// }
	//
	// @RequestMapping(method = RequestMethod.PUT)
	// public GroupGetDto createGroup(@Valid @RequestBody GroupCreateDto dto) {
	// Group group = new Group();
	// group.setName(dto.getName());
	// group.setCurator(userService.get(dto.getCurator()));
	// return new GroupGetDto(groupService.create(group));
	// }
	//
	// @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	// public void deleteGroup(@PathVariable("id") Long id) {
	// Group group = new Group();
	// group.setId(id);
	// groupService.delete(group);
	// }
	//
	// @RequestMapping(value = "{id}", method = RequestMethod.POST)
	// public void updateGroup(@PathVariable("id") Long id, @Valid @RequestBody
	// GroupDto dto) {
	// Group group = groupService.get(id);
	// group.setName(dto.getName());
	// group.setCurator(userService.get(dto.getCurator()));
	// groupService.update(group);
	// }
	//
	// @RequestMapping(value="all", method = RequestMethod.GET, produces =
	// "application/json")
	// public List<GroupGetDto> getAllGroups() {
	// return
	// groupService.getAll().stream().map(GroupGetDto::new).collect(Collectors.toList());
	// }
	//
	// @RequestMapping(value = "search", method = RequestMethod.GET, produces =
	// "application/json")
	// public List<GroupGetDto> search(@RequestParam(value = "sort", required =
	// false) String sortBy,
	// @RequestParam(value = "id", required = false) Long id,
	// @RequestParam(value = "name", required = false) String name,
	// @RequestParam(value = "curator", required = false) Long curator,
	// @RequestParam("limit") Integer limit,
	// @RequestParam("offset") Integer offset, @RequestParam("asc") boolean asc)
	// {
	// GroupSearchParams searchParam = new GroupSearchParams(id, name, curator);
	// SortParam sortParam = SortParam.getValueOf(sortBy);
	// List<GroupGetDto> result = groupService.search(sortParam, searchParam,
	// limit, offset, asc).stream()
	// .map(GroupGetDto::new).collect(Collectors.toList());
	// return result;
	// }
	//
	// @RequestMapping(value = "count", method = RequestMethod.GET, produces =
	// "application/json")
	// public Long groupCount(@RequestParam(value = "id", required = false) Long
	// id,
	// @RequestParam(value = "name", required = false) String name,
	// @RequestParam(value = "curator", required = false) Long curator) {
	// GroupSearchParams searchParam = new GroupSearchParams(id, name, curator);
	// return groupService.count(searchParam);
	// }
	//
	// @RequestMapping(value = "{group}/add/lesson/{lesson}", method =
	// RequestMethod.GET)
	// public void addPairToGroup(@PathVariable("lesson") Long idPair,
	// @PathVariable("group") Long idGroup) {
	// groupService.addLessonToGroup(idPair, idGroup);
	// }
	//
	// @RequestMapping(value = "{group}/remove/lesson/{lesson}", method =
	// RequestMethod.GET)
	// public void removePairFromGroup(@PathVariable("lesson") Long idPair,
	// @PathVariable("group") Long idGroup) {
	// groupService.removeLessonFromGroup(idPair, idGroup);
	// }
	//
	// @RequestMapping(value = "{group}/add/student/{student}", method =
	// RequestMethod.GET)
	// public void addStudentToGroup(@PathVariable("student") Long idStudent,
	// @PathVariable("group") Long idGroup) {
	// groupService.addStudentToGroup(idStudent, idGroup);
	// }
	//
	// @RequestMapping(value = "{group}/remove/student/{student}", method =
	// RequestMethod.GET)
	// public void removeStudentFromGroup(@PathVariable("student") Long
	// idStudent) {
	// groupService.removeStudentFromGroup(idStudent);
	// }
	//
	// @RequestMapping(value = "{id}/add/student", method = RequestMethod.POST)
	// public void addStudentsToGroup(@PathVariable("id") Long idGroup,
	// @RequestBody List<Long> students) {
	// groupService.addstudentsToGroup(idGroup, students);
	// }

	@RequestMapping(value = "dictionary", method = RequestMethod.GET)
	public List<DictionaryItem> getDictionary() {
		return roomService.getDictionary();
	}

	// @RequestMapping(value = "lesson/{lesson}", method = RequestMethod.GET)
	// public List<GroupGetDto> getGroupsByLessonId(@PathVariable("pair") Long
	// idPair) {
	// List<GroupGetDto> result =
	// groupService.getGroupsByLessonId(idPair).stream().map(GroupGetDto::new)
	// .collect(Collectors.toList());
	// return result;
	// }
	//
	// @RequestMapping(value = "/nolesson/{lesson}", method = RequestMethod.GET)
	// public List<GroupGetDto> getGroupsWithoutLesson(@PathVariable("pair")
	// Long idPair) {
	// List<GroupGetDto> result =
	// groupService.getGroupsWithoutLesson(idPair).stream().map(GroupGetDto::new)
	// .collect(Collectors.toList());
	// return result;
	// }
}
