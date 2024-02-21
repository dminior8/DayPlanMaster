package pl.dminior8.DayPlanMaster.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import pl.dminior8.DayPlanMaster.model.Task;

@Converter(autoApply = true)
public class CategoryConverter implements AttributeConverter<Task.Category, String> {

    @Override
    public String convertToDatabaseColumn(Task.Category attribute) {
        return attribute.name().toUpperCase();
    }

    @Override
    public Task.Category convertToEntityAttribute(String dbData) {
        return Task.Category.valueOf(dbData.toUpperCase());
    }
}
