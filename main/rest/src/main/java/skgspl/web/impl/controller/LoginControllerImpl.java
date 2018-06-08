package skgspl.web.impl.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import skgspl.dao.util.CodeEnum;
import skgspl.service.api.UserService;
import skgspl.web.dto.CodeMessageDto;
import skgspl.web.dto.UserCredsDto;
import skgspl.web.dto.UserRegisterDto;
import skgspl.web.util.JWTManager;

@RestController
public class LoginControllerImpl {
/*
	@Autowired
	StudentService studentService;
	@Autowired
	LecturerService lecturerService;
	@Autowired
	UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public CodeMessageDto login(@Valid @RequestBody UserCredsDto dto) {
		CodeEnum code = userService.checkUser(dto.getLogin(), dto.getPassword());
		if (code == CodeEnum.SUCCESS_AUTH) {
			return new CodeMessageDto(CodeEnum.SUCCESS_AUTH,
					JWTManager.createToken(userService.getUserByLogin(dto.getLogin())));
		} else {
			return new CodeMessageDto(code);
		}
	}

	@RequestMapping(value = "/user/registrate", method = RequestMethod.POST)
	public CodeMessageDto registrageUser(@Valid @RequestBody UserRegisterDto dto) {
		if (!userService.isUserExist(dto.getLogin())) {
			String role = dto.getRole();
			Person person = role.equals("student") ? new Student() : new Lecturer();
			person.setEmail(dto.getEmail());
			person.setLogin(dto.getLogin());
			person.setName(dto.getName());
			person.setPassword(dto.getPassword());
			person.setNumber(dto.getNumber());
			if (role.equals("student")) {
				studentService.create((Student) person);
			} else {
				lecturerService.create((Lecturer) person);
			}
			return new CodeMessageDto(CodeEnum.LOGIN_NOT_EXIST);
		} else {
			return new CodeMessageDto(CodeEnum.LOGIN_EXIST);
		}
	}*/
}
