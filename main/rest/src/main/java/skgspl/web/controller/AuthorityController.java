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

//import skgspl.dao.search.AuthoritySearchParams;
import skgspl.dao.search.SortParam;
//import skgspl.dto.authority.AuthorityCreateDto;
//import skgspl.dto.authority.AuthorityGetDto;
//import skgspl.dto.authority.AuthorityUpdateDto;
import skgspl.entity.Authority;
import skgspl.entity.util.DictionaryItem;
import skgspl.service.api.AuthorityService;
import skgspl.service.api.RoleService;
import skgspl.service.api.AuthorityService;
import skgspl.service.api.UserService;

@RestController
@RequestMapping("/api/authority/")
public class AuthorityController {
	@Autowired
	AuthorityService authorityService;
	@Autowired
	RoleService roleService;

	/*
	 * @RequestMapping(value = "{id}", method = RequestMethod.GET, produces =
	 * "application/json") public AuthorityGetDto
	 * getAuthority(@PathVariable("id") Long id) { return new
	 * AuthorityGetDto(authorityService.get(id)); }
	 * 
	 * @RequestMapping(method = RequestMethod.PUT) public AuthorityGetDto
	 * createAuthority(@Valid @RequestBody AuthorityCreateDto dto) { Authority
	 * authority = new Authority(); authority.setName(dto.getName()); authority
	 * = authorityService.create(authority);
	 * authorityService.updateAuthoritiesByAuthority(authority.getId(),
	 * dto.getAuthorities()); return new AuthorityGetDto(authority); }
	 * 
	 * @RequestMapping(value = "{id}", method = RequestMethod.DELETE) public
	 * void deleteAuthority(@PathVariable("id") Long id) { Authority authority =
	 * new Authority(); authority.setId(id); authorityService.delete(authority);
	 * }
	 * 
	 * @RequestMapping(value = "{id}", method = RequestMethod.POST) public void
	 * updateAuthority(@PathVariable("id") Long id, @Valid @RequestBody
	 * AuthorityUpdateDto dto) { Authority authority = authorityService.get(id);
	 * authority.setName(dto.getName()); authorityService.update(authority);
	 * authorityService.updateAuthoritiesByAuthority(authority.getId(),
	 * dto.getAuthorities()); }
	 * 
	 * @RequestMapping(value="all", method = RequestMethod.GET, produces =
	 * "application/json") public List<AuthorityGetDto> getAllAuthoritys() {
	 * return
	 * authorityService.getAll().stream().map(AuthorityGetDto::new).collect(
	 * Collectors.toList()); }
	 * 
	 * @RequestMapping(value = "search", method = RequestMethod.GET, produces =
	 * "application/json") public List<AuthorityGetDto>
	 * search(@RequestParam(value = "sort", required = false) String sortBy,
	 * 
	 * @RequestParam(value = "id", required = false) Long id,
	 * 
	 * @RequestParam(value = "name", required = false) String
	 * name, @RequestParam(value = "curator", required = false) Long curator,
	 * 
	 * @RequestParam("limit") Integer limit,
	 * 
	 * @RequestParam("offset") Integer offset, @RequestParam("asc") boolean asc)
	 * { AuthoritySearchParams searchParam = new AuthoritySearchParams(id, name,
	 * curator); SortParam sortParam = SortParam.getValueOf(sortBy);
	 * List<AuthorityGetDto> result = authorityService.search(sortParam,
	 * searchParam, limit, offset, asc).stream()
	 * .map(AuthorityGetDto::new).collect(Collectors.toList()); return result; }
	 * 
	 * @RequestMapping(value = "count", method = RequestMethod.GET, produces =
	 * "application/json") public Long authorityCount(@RequestParam(value =
	 * "id", required = false) Long id,
	 * 
	 * @RequestParam(value = "name", required = false) String
	 * name, @RequestParam(value = "curator", required = false) Long curator) {
	 * AuthoritySearchParams searchParam = new AuthoritySearchParams(id, name,
	 * curator); return authorityService.count(searchParam); }
	 * 
	 * @RequestMapping(value = "{authority}/add/lesson/{lesson}", method =
	 * RequestMethod.GET) public void addPairToAuthority(@PathVariable("lesson")
	 * Long idPair, @PathVariable("authority") Long idAuthority) {
	 * authorityService.addLessonToAuthority(idPair, idAuthority); }
	 * 
	 * @RequestMapping(value = "{authority}/remove/lesson/{lesson}", method =
	 * RequestMethod.GET) public void
	 * removePairFromAuthority(@PathVariable("lesson") Long
	 * idPair, @PathVariable("authority") Long idAuthority) {
	 * authorityService.removeLessonFromAuthority(idPair, idAuthority); }
	 * 
	 * @RequestMapping(value = "{authority}/add/student/{student}", method =
	 * RequestMethod.GET) public void
	 * addStudentToAuthority(@PathVariable("student") Long
	 * idStudent, @PathVariable("authority") Long idAuthority) {
	 * authorityService.addStudentToAuthority(idStudent, idAuthority); }
	 * 
	 * @RequestMapping(value = "{authority}/remove/student/{student}", method =
	 * RequestMethod.GET) public void
	 * removeStudentFromAuthority(@PathVariable("student") Long idStudent) {
	 * authorityService.removeStudentFromAuthority(idStudent); }
	 * 
	 * @RequestMapping(value = "{id}/add/student", method = RequestMethod.POST)
	 * public void addStudentsToAuthority(@PathVariable("id") Long
	 * idAuthority, @RequestBody List<Long> students) {
	 * authorityService.addstudentsToAuthority(idAuthority, students); }
	 */
	@RequestMapping(value = "dictionary", method = RequestMethod.GET)
	public List<DictionaryItem> getDictionary() {
		return authorityService.getDictionary();
	}

	@RequestMapping(value = "dictionary/role/{id}", method = RequestMethod.GET)
	public List<DictionaryItem> getDictionaryByRole(@PathVariable("id") Long idRole) {
		return authorityService.getDictionaryByRole(idRole);
	}

	@RequestMapping(value = "dictionary/user/{id}", method = RequestMethod.GET)
	public List<DictionaryItem> getDictionaryByUser(@PathVariable("id") Long idUser) {
		return authorityService.getDictionaryByUser(idUser);
	}
	// @RequestMapping(value = "lesson/{lesson}", method = RequestMethod.GET)
	// public List<AuthorityGetDto>
	// getAuthoritysByLessonId(@PathVariable("pair") Long idPair) {
	// List<AuthorityGetDto> result =
	// authorityService.getAuthoritysByLessonId(idPair).stream().map(AuthorityGetDto::new)
	// .collect(Collectors.toList());
	// return result;
	// }
	//
	// @RequestMapping(value = "/nolesson/{lesson}", method = RequestMethod.GET)
	// public List<AuthorityGetDto>
	// getAuthoritysWithoutLesson(@PathVariable("pair") Long idPair) {
	// List<AuthorityGetDto> result =
	// authorityService.getAuthoritysWithoutLesson(idPair).stream().map(AuthorityGetDto::new)
	// .collect(Collectors.toList());
	// return result;
	// }
}
