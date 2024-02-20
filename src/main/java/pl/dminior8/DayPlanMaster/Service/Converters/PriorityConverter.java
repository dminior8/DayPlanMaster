package pl.dminior8.DayPlanMaster.Service.Converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import pl.dminior8.DayPlanMaster.Model.Tasks;

@Converter(autoApply = true)
public class PriorityConverter implements AttributeConverter<Tasks.Priority, String> {

    @Override
    public String convertToDatabaseColumn(Tasks.Priority attribute) {
        return attribute.name();
    }

    @Override
    public Tasks.Priority convertToEntityAttribute(String dbData) {
        return Tasks.Priority.valueOf(dbData);
    }
}

