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

//import skgspl.dao.search.RoleSearchParams;
import skgspl.dao.search.SortParam;
import skgspl.dto.role.RoleCreateDto;
import skgspl.dto.role.RoleGetDto;
import skgspl.dto.role.RoleUpdateDto;
import skgspl.entity.Role;
import skgspl.entity.util.DictionaryItem;
import skgspl.service.api.AuthorityService;
import skgspl.service.api.RoleService;import skgspl.service.api.UserService;

@RestController
@RequestMapping("/api/role/")
public class RoleController {
	@Autowired
	RoleService roleService;
	@Autowired
	AuthorityService authorityService;

	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
	public RoleGetDto getRole(@PathVariable("id") Long id) {
		return new RoleGetDto(roleService.get(id));
	}

	@RequestMapping(method = RequestMethod.PUT)
	public RoleGetDto createRole(@Valid @RequestBody RoleCreateDto dto) {
		Role role = new Role();
		role.setName(dto.getName());
		role = roleService.create(role);
		authorityService.updateAuthoritiesByRole(role.getId(), dto.getAuthorities());
		return new RoleGetDto(role);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteRole(@PathVariable("id") Long id) {
		Role role = new Role();
		role.setId(id);
		roleService.delete(role);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.POST)
	public void updateRole(@PathVariable("id") Long id, @Valid @RequestBody RoleUpdateDto dto) {
		Role role = roleService.get(id);
		role.setName(dto.getName());
		roleService.update(role);
		authorityService.updateAuthoritiesByRole(role.getId(), dto.getAuthorities());
	}

	@RequestMapping(value="all", method = RequestMethod.GET, produces = "application/json")
	public List<RoleGetDto> getAllRoles() {
		return roleService.getAll().stream().map(RoleGetDto::new).collect(Collectors.toList());
	}

/*	@RequestMapping(value = "search", method = RequestMethod.GET, produces = "application/json")
	public List<RoleGetDto> search(@RequestParam(value = "sort", required = false) String sortBy,
			@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "name", required = false) String name, @RequestParam(value = "curator", required = false) Long curator, 
			@RequestParam("limit") Integer limit,
			@RequestParam("offset") Integer offset, @RequestParam("asc") boolean asc) {
		RoleSearchParams searchParam = new RoleSearchParams(id, name, curator);
		SortParam sortParam = SortParam.getValueOf(sortBy);
		List<RoleGetDto> result = roleService.search(sortParam, searchParam, limit, offset, asc).stream()
				.map(RoleGetDto::new).collect(Collectors.toList());
		return result;
	}

	@RequestMapping(value = "count", method = RequestMethod.GET, produces = "application/json")
	public Long roleCount(@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "name", required = false) String name, @RequestParam(value = "curator", required = false) Long curator) {
		RoleSearchParams searchParam = new RoleSearchParams(id, name, curator);
		return roleService.count(searchParam);
	}

	@RequestMapping(value = "{role}/add/lesson/{lesson}", method = RequestMethod.GET)
	public void addPairToRole(@PathVariable("lesson") Long idPair, @PathVariable("role") Long idRole) {
		roleService.addLessonToRole(idPair, idRole);
	}

	@RequestMapping(value = "{role}/remove/lesson/{lesson}", method = RequestMethod.GET)
	public void removePairFromRole(@PathVariable("lesson") Long idPair, @PathVariable("role") Long idRole) {
		roleService.removeLessonFromRole(idPair, idRole);
	}

	@RequestMapping(value = "{role}/add/student/{student}", method = RequestMethod.GET)
	public void addStudentToRole(@PathVariable("student") Long idStudent, @PathVariable("role") Long idRole) {
		roleService.addStudentToRole(idStudent, idRole);
	}

	@RequestMapping(value = "{role}/remove/student/{student}", method = RequestMethod.GET)
	public void removeStudentFromRole(@PathVariable("student") Long idStudent) {
		roleService.removeStudentFromRole(idStudent);
	}

	@RequestMapping(value = "{id}/add/student", method = RequestMethod.POST)
	public void addStudentsToRole(@PathVariable("id") Long idRole, @RequestBody List<Long> students) {
		roleService.addstudentsToRole(idRole, students);
	}
*/
	@RequestMapping(value = "dictionary", method = RequestMethod.GET)
	public List<DictionaryItem> getDictionary() {
		return roleService.getDictionary();
	}

//	@RequestMapping(value = "lesson/{lesson}", method = RequestMethod.GET)
//	public List<RoleGetDto> getRolesByLessonId(@PathVariable("pair") Long idPair) {
//		List<RoleGetDto> result = roleService.getRolesByLessonId(idPair).stream().map(RoleGetDto::new)
//				.collect(Collectors.toList());
//		return result;
//	}
//
//	@RequestMapping(value = "/nolesson/{lesson}", method = RequestMethod.GET)
//	public List<RoleGetDto> getRolesWithoutLesson(@PathVariable("pair") Long idPair) {
//		List<RoleGetDto> result = roleService.getRolesWithoutLesson(idPair).stream().map(RoleGetDto::new)
//				.collect(Collectors.toList());
//		return result;
//	}
}
