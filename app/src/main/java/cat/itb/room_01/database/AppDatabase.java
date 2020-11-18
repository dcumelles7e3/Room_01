package cat.itb.room_01.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Alumno.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public static AppDatabase INSTANCE;

    public abstract AlumnoDao alumnoDao();

    public static AppDatabase getInstance(Context context){
        if (INSTANCE==null){
            INSTANCE = Room.databaseBuilder(context, AppDatabase.class, "Alumnos.db").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return INSTANCE;
    }

}
