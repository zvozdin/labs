package patterns.juja.observer.sample.soft;

import java.util.Collection;
import java.util.Set;

public interface Candidate {

    void update(Collection<Vacancy> vacancies);

    Set<String> getTechnologies();
}