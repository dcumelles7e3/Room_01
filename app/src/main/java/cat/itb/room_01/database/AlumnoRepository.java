package cat.itb.room_01.database;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public class AlumnoRepository {
    AlumnoDao dao;

    public AlumnoRepository(AlumnoDao dao) {
        this.dao = dao;
    }

    public List<Alumno> getAll(){
        return this.dao.getAll();
    }

    public void insert(Alumno a){
        this.dao.insert(a);
    }

    public void update(Alumno a){
        this.dao.update(a);
    }

    public void delete(Alumno a){
        this.dao.delete(a);
    }

    public Alumno findById(int idAlumno){
        return this.dao.findById(idAlumno);
    }

    public List<Alumno> findByCurso(String curso){
        return this.dao.findByCurso(curso);
    }
}
