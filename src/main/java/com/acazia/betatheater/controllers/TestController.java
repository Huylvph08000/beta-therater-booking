package com.acazia.betatheater.controllers;

import com.acazia.betatheater.base.BaseResponseDto;
import com.acazia.betatheater.dto.produce.FilmProduceDto;
import com.acazia.betatheater.mapper.FilmMapper;
import com.acazia.betatheater.models.Film;
import com.acazia.betatheater.models.FilmTicket;
import com.acazia.betatheater.repository.FilmRepository;
import com.acazia.betatheater.service.FilmService;
import com.acazia.betatheater.service.FilmTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {


	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}

	@GetMapping("/user")
	@PreAuthorize("hasAnyAuthority('USER')  or hasAnyAuthority('MODERATOR') or hasAnyAuthority('ADMIN')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}

	@Autowired
	FilmService filmService;

	@Autowired
	FilmTicketService filmTicketService;

	@Autowired
	FilmRepository filmRepository;

	@Autowired
	FilmMapper filmMapper;

//	@GetMapping("/films")
//	public ResponseEntity<BaseResponseDto> getAllFilms(){
//		return ResponseEntity.ok(BaseResponseDto.success(filmRepository.findAll(), "Get films successfully!"));
//	}
//	@GetMapping("/filmTicket/film/{id}")
//	public ResponseEntity<BaseResponseDto> getFilmTicketByFilmId(@PathVariable("id") Long id){
//		return ResponseEntity.ok(BaseResponseDto.success(filmTicketService.findByFilmsId(id), "Get film Ticket successfully!"));
//	}

//	@GetMapping("/filmTicket/film/{id}")
//	public FilmTicket getFilmTicketByFilmId(@PathVariable("id") Long id){
//		return filmTicketService.findByFilmsId(id);
//	}
	@GetMapping("/films/{id}")
	public FilmProduceDto getById(@PathVariable("id") Long id){
//		return filmMapper.filmRepository.findById(id).get();
		Optional<FilmProduceDto> filmProduceDto = filmMapper.toDetailFilm(filmRepository.findById(id));
		return filmProduceDto.get();
	}

//	@GetMapping("/films")
//	public ResponseEntity getAllFilms(@RequestParam(defaultValue = "0") int page,
//									  @RequestParam(defaultValue = "5") int size) {
//		try {
//			List<Film> filmList = new ArrayList<Film>();
//			Pageable paging = PageRequest.of(page, size);
//			Page<Film> filmPage = filmService.getAllFilms(paging);
//			filmList = filmPage.getContent();
//
//			Map<String, Object> response = new HashMap<>();
//			response.put("filmList", filmList);
//			response.put("currentPage", filmPage.getNumber());
//			response.put("totalItems", filmPage.getTotalElements());
//			response.put("totalPages", filmPage.getTotalPages());
//			return new ResponseEntity<>(response, HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
}
