package patterns.juja.observer.sample.soft;

public interface Recruiter {

    void register(Candidate candidate);
    void remove(Candidate candidate);
    void addNew(Vacancy vacancy);
    void notice();
}