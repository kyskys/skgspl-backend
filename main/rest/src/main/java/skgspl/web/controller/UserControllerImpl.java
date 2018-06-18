package skgspl.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import skgspl.dto.UserDetailsDto;
import skgspl.entity.User;
import skgspl.entity.util.DictionaryItem;
import skgspl.holder.support.CurrentUserSupport;
import skgspl.service.api.UserService;

@RestController
@RequestMapping("/api/user/")
public class UserControllerImpl implements CurrentUserSupport {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "lecturer/dictionary", method = RequestMethod.GET)
	public List<DictionaryItem> getLecturerDictionary() {
		return userService.getLecturerDictionary();
	}
	
	/*
	 * @RequestMapping(value = "profile/details/", method = RequestMethod.GET)
	 * public UserDetailsDto getUserDetails() { return new
	 * UserDetailsDto(getCurrentUser()); }
	 * 
	 * @RequestMapping(value = "name", method = RequestMethod.GET) public String
	 * getUserName() { return "{\"name\" : \"" + getCurrentUser().getName() +
	 * "\"}"; }
	 * 
	 * @RequestMapping(value="role",method=RequestMethod.GET) public String
	 * getUserRole() { return "{\"role\" : \"" +
	 * getCurrentUser().getRole().getValue() + "\"}"; }
	 * 
	 * @RequestMapping(value = "profile/details/", method = RequestMethod.POST)
	 * private UserDetailsDto updateUserDetails(@Valid @RequestBody
	 * UserDetailsDto dto) { User user =
	 * userService.get(getCurrentUser().getId()); String email = dto.getEmail();
	 * if (!StringUtils.isEmpty(email)) { user.setEmail(email); } String name =
	 * dto.getName(); if (!StringUtils.isEmpty(name)) { user.setName(name); }
	 * String number = dto.getNumber(); if (!StringUtils.isEmpty(number)) {
	 * user.setNumber(number); } userService.update(user); return new
	 * UserDetailsDto(user); }
	 */

	
}
