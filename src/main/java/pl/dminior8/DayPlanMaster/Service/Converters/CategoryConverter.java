package pl.dminior8.DayPlanMaster.Service.Converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import pl.dminior8.DayPlanMaster.Model.Tasks;

@Converter(autoApply = true)
public class CategoryConverter implements AttributeConverter<Tasks.Category, String> {

    @Override
    public String convertToDatabaseColumn(Tasks.Category attribute) {
        return attribute.name().toUpperCase();
    }

    @Override
    public Tasks.Category convertToEntityAttribute(String dbData) {
        return Tasks.Category.valueOf(dbData.toUpperCase());
    }
}
