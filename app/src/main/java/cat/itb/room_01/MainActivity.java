package cat.itb.room_01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Menu;
import android.view.ContextMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import cat.itb.room_01.database.Alumno;
import cat.itb.room_01.database.AlumnoDao;
import cat.itb.room_01.database.AlumnoRepository;
import cat.itb.room_01.database.AppDatabase;


public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private FloatingActionButton addButton;
    private MyAdapter adapter;
    private List<Alumno> alumnos;

    static AppDatabase db;
    static AlumnoDao dao;
    static AlumnoRepository repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        addButton = findViewById(R.id.addButton);

        db = AppDatabase.getInstance(this.getApplicationContext());
        dao = db.alumnoDao();
        repo = new AlumnoRepository(dao);

        alumnos = repo.getAll();
        adapter = new MyAdapter(this,R.layout.item_list, alumnos);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repo.insert(new Alumno("Ekisde", "DAMi2A"));
                alumnos=repo.getAll();
                adapter.setAlumnos(alumnos);

            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle(this.alumnos.get(info.position).getNombre());

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.delete_item:
                repo.delete(repo.findById(info.position));
                alumnos=repo.getAll();
                adapter.setAlumnos(alumnos);

                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}