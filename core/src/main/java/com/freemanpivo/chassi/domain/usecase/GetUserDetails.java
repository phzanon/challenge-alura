package com.freemanpivo.chassi.domain.usecase;

import com.freemanpivo.chassi.domain.model.User;
import com.freemanpivo.chassi.domain.port.GetModelPort;
import com.freemanpivo.chassi.domain.port.RetrieveUserStored;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class GetUserDetails implements GetModelPort<User> {
    private final RetrieveUserStored usecase;

    @Override
    public User getDetails(Long id) {
        final var user = usecase.getById(id);

        if (user.isEmpty()) {
            // TODO: remove generic exception and add a business one. Handle it at ControllerAdvice.
            throw new RuntimeException("error");
        }
        var userWithAge = user.get();
        userWithAge.setAgeInYears(calculateAge(userWithAge.getBirthDate()));

        return userWithAge;
    }

    @Override
    public List<User> getAll() {
        List<User> users = usecase.getAll();
        users.forEach(user -> user.setAgeInYears(calculateAge(user.getBirthDate())));

        return users;
    }

    private String calculateAge(LocalDate bithDate) {
        return String.valueOf(ChronoUnit.YEARS.between(bithDate, LocalDate.now()));
    }
}
