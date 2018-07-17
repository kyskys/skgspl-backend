package skgspl.aspect;

import java.util.Set;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import skgspl.entity.Authority;
import skgspl.holder.support.CurrentUserSupport;

@Aspect
@Component
public class AuthorityAspect implements CurrentUserSupport {

	@Around("@annotation(authorityCheck)")
	public <T> T handleInvoke(ProceedingJoinPoint joinPoint, AuthorityCheck authorityCheck) {
		try {
			//boolean haveAuthority = true;
			String[] availableAuthorities = authorityCheck.authorities();
//			Set<Authority> userAuthorities = getCurrentUser().getRole() != null
//					? getCurrentUser().getRole().getAuthorities() : getCurrentUser().getAuthorities();
			for (String authority : availableAuthorities) {
				System.out.println(authority);
			}
			return (T) joinPoint.proceed();
		} catch (Throwable throwable) {
			throw new RuntimeException(throwable);
		}
	}
}
