package by.teachmeskills.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Project {
    String projectName;
    String projectCode;
    String description;
    AccessType type;
    MemberAccess members;
}
