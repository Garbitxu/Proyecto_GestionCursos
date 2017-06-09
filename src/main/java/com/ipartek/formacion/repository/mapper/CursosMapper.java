package com.ipartek.formacion.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.domain.Cursos;

public class CursosMapper implements RowMapper<Cursos> {
	@Override()
	public Cursos mapRow(ResultSet rs, int numRow) throws SQLException {

		Cursos cursos = new Cursos();

		cursos.setId(rs.getLong("id"));
		cursos.setNombre(rs.getString("NomCurso"));
		cursos.setCodigo(rs.getString("CodCurso"));

		return cursos;
	}

}
