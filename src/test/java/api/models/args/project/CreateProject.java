package api.models.args.project;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CreateProject {
    private String name;
}
