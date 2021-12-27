package com.luv2code.spring.firstTest.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.luv2code.spring.firstTest.entity.ListMovie;


public interface ListMovieRepositry extends JpaRepository<ListMovie, Integer> {

	public ListMovie findByName(String name);
	// public ListMovie findTopByOrderByMoviesDesc();
	@Query("select  m.listId ,count(m.id) as ex from Movie m group by m.listId order by ex desc")
	public List<Object[]> getTheMost();
}
