mpackage com.dac.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.dac.security.entity.Student;
import com.dac.security.repo.StudentRepository;



public class CustomUserDetailsService implements UserDetailsService {

	
	@Autowired
	StudentRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
Student student=repository.findByName(username);
		
		if(student==null)
			throw new UsernameNotFoundException(username);
		
		return new CustomUserDetails(student);
	}

}
