package br.ufpb.dcx.dsc.figurinhas.repository;

import br.ufpb.dcx.dsc.figurinhas.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByEmail(String email);
}
