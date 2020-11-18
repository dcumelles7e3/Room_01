package cat.itb.room_01.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "alumno_table")
public class Alumno {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_alumno")
    private int idAlumno;
    private String nombre, curso;

    public Alumno(String nombre, String curso) {
        this.nombre = nombre;
        this.curso = curso;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }


}
