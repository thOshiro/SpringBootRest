package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import entity.Investor;


@Repository
public interface InvestorRepo extends CrudRepository<Investor, Long> {

	public Investor findByName(String name);

}
