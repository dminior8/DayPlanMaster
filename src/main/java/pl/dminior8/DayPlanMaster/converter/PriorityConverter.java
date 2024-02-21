package pl.dminior8.DayPlanMaster.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import pl.dminior8.DayPlanMaster.model.Task;

@Converter(autoApply = true)
public class PriorityConverter implements AttributeConverter<Task.Priority, String> {

    @Override
    public String convertToDatabaseColumn(Task.Priority attribute) {
        return attribute.name();
    }

    @Override
    public Task.Priority convertToEntityAttribute(String dbData) {
        return Task.Priority.valueOf(dbData);
    }
}

