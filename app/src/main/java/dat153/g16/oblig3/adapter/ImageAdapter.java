package dat153.g16.oblig3.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import dat153.g16.oblig3.R;
import dat153.g16.oblig3.model.Question;

public class ImageAdapter extends BaseAdapter {
    private final Context context;
    private final List<Question> questions;

    public ImageAdapter(Context context, List<Question> questions) {
        super();

        this.context = context;
        this.questions = questions;
    }

    @Override
    public int getCount() {
        return questions.size();
    }

    @Override
    public Object getItem(int index) {
        return questions.get(index);
    }

    @Override
    public long getItemId(int index) {
        return 0;
    }

    @Override
    public View getView(int index, View convertView, ViewGroup parent) {
        // Create a new view if it doesn't exist, otherwise use the existing view
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false);
        }

        // Get the image and text views
        ImageView imageView = view.findViewById(R.id.image);
        TextView textView = view.findViewById(R.id.text);

        Question question = questions.get(index);
        if (question.isUsingUri()) {
            // Question is using uri
            imageView.setImageURI(question.getUri());
        } else {
            // Question is using resource id
            imageView.setImageResource(question.getResId());
        }
        // Set the text view to the answer
        textView.setText(question.getAnswer());

        return view;
    }
}
