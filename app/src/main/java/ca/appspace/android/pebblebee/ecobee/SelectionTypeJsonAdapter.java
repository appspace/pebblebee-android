package ca.appspace.android.pebblebee.ecobee;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Created by eugene on 2015-02-22.
 */
public class SelectionTypeJsonAdapter extends TypeAdapter<SelectionType> {
	@Override
	public void write(JsonWriter out, SelectionType value) throws IOException {
		out.value(value.asJsonValue());
	}

	@Override
	public SelectionType read(JsonReader in) throws IOException {
		String jsonVal = in.nextString();
		if (jsonVal==null || jsonVal.trim().isEmpty()) {
			return null;
		}
		for (SelectionType type : SelectionType.values()) {
			if (type.asJsonValue().equalsIgnoreCase(jsonVal)) {
				return type;
			}
		}
		return null;
	}
}
