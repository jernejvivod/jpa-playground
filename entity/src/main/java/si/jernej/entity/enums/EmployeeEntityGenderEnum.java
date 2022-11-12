package si.jernej.entity.enums;

import java.util.Arrays;

import jakarta.persistence.AttributeConverter;

public enum EmployeeEntityGenderEnum
{
    MALE("M"),
    FEMALE("F");

    private final String value;

    EmployeeEntityGenderEnum(String value)
    {
        this.value = value;
    }

    public static class JPAConverter implements AttributeConverter<EmployeeEntityGenderEnum, String>
    {
        @Override
        public String convertToDatabaseColumn(EmployeeEntityGenderEnum attribute)
        {
            return attribute != null ? attribute.value : null;
        }

        @Override
        public EmployeeEntityGenderEnum convertToEntityAttribute(String dbData)
        {
            return Arrays.stream(EmployeeEntityGenderEnum.values())
                    .filter(v -> v.value.equals(dbData))
                    .findAny()
                    .orElse(null);
        }
    }
}
