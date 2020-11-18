package cat.itb.room_01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import cat.itb.room_01.database.Alumno;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Alumno> alumnos;

    public MyAdapter(Context context, int layout, List<Alumno> alumnos) {
        this.context = context;
        this.layout = layout;
        this.alumnos = alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return this.alumnos.size();
    }

    @Override
    public Object getItem(int position) {
        return this.alumnos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView == null) {
            convertView = LayoutInflater.from(this.context).inflate(this.layout, null);
            vh = new ViewHolder();
            vh.textViewNom = convertView.findViewById(R.id.textViewNom);
            vh.textViewCurso = convertView.findViewById(R.id.textViewCurso);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        Alumno a = (Alumno) getItem(position);
        vh.textViewNom.setText(a.getNombre());
        vh.textViewCurso.setText(a.getCurso());
        return convertView;
    }

    static class ViewHolder {
        private TextView textViewNom;
        private TextView textViewCurso;
    }
}
