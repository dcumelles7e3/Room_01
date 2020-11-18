package cat.itb.room_01.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AlumnoDao {

    @Query("SELECT * FROM alumno_table")
    List<Alumno> getAll();

    @Insert
    void insert(Alumno a);

    @Update
    void update(Alumno a);

    @Delete
    void delete(Alumno a);

    @Query("SELECT * FROM alumno_table WHERE id_alumno = :idAlumno")
    Alumno findById(int idAlumno);

    @Query("SELECT * FROM alumno_table WHERE curso = :curso")
    List<Alumno> findByCurso(String curso);
}
