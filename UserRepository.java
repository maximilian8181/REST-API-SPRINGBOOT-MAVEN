package com.exercise.springboot_app.repository;

import com.exercise.springboot_app.model.Address;
import com.exercise.springboot_app.model.User;
import com.exercise.springboot_app.util.PasswordUtil;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class UserRepository {

    private List<User> users = new ArrayList<>();

    public UserRepository() {
        // Crear direcciones de ejemplo
        Address workAddress1 = new Address(1, "Street No. 1", "UK");
        Address homeAddress1 = new Address(2, "Street No. 2", "AU");
        Address mexicoAddress = new Address(5, "Del Carmen 26", "MX");

        Address workAddress2 = new Address(3, "Street No. 3", "US");
        Address homeAddress2 = new Address(4, "Street No. 4", "CA");

        // Crear un mapa de direcciones para cada usuario
        Map<String, Address> addresses1 = new HashMap<>();
        addresses1.put("workaddress", workAddress1);
        addresses1.put("homeaddress", homeAddress1);
        addresses1.put("mexicoaddress", mexicoAddress);

        Map<String, Address> addresses2 = new HashMap<>();
        addresses2.put("workaddress", workAddress2);
        addresses2.put("homeaddress", homeAddress2);

        // Cifrar contraseñas
        String hashedPassword1 = PasswordUtil.hashPassword("123456");
        String hashedPassword2 = PasswordUtil.hashPassword("abcdef");

        // Crear usuarios de ejemplo con contraseñas cifradas
        User user1 = new User(123, "user2@mail.com", "user1", hashedPassword1, null, addresses1);
        User user2 = new User(124, "user1@mail.com", "user2", hashedPassword2, null, addresses2);

        // Agregar usuarios a la lista
        users.add(user1);
        users.add(user2);
    }

    // Método para obtener todos los usuarios ordenados por un atributo específico (ej. email)
    public List<User> findAllSortedBy(String attribute) {
        return users.stream()
                .sorted((u1, u2) -> {
                    switch (attribute) {
                        case "email":
                            return u1.getEmail().compareTo(u2.getEmail());
                        case "name":
                            return u1.getName().compareTo(u2.getName());
                        default:
                            return u1.getId() - u2.getId();
                    }
                })
                .collect(Collectors.toList());
    }

    // Método para obtener las direcciones de un usuario dado su ID
    public List<Address> findAddressesByUserId(int userId) {
        User user = findById(userId);
        if (user != null) {
            return new ArrayList<>(user.getAddresses().values());
        }
        return Collections.emptyList();
    }

    // Método para actualizar una dirección de un usuario dado su ID y el ID de la dirección
    public Address updateAddress(int userId, int addressId, Address newAddress) {
        User user = findById(userId);
        if (user != null) {
            Map<String, Address> addresses = user.getAddresses();
            for (Map.Entry<String, Address> entry : addresses.entrySet()) {
                if (entry.getValue().getId() == addressId) {
                    entry.setValue(newAddress);
                    return newAddress;
                }
            }
        }
        return null;
    }

    // Método para guardar un nuevo usuario
    public User save(User user) {
        String hashedPassword = PasswordUtil.hashPassword(user.getPassword());
        user.setPassword(hashedPassword);
        users.add(user);
        return user;
    }

    // Método para encontrar un usuario por su ID
    public User findById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    // Método para actualizar un atributo de un usuario por su ID
    public User updateUserAttribute(int userId, String attribute, String value) {
        User user = findById(userId);
        if (user != null) {
            switch (attribute) {
                case "email":
                    user.setEmail(value);
                    break;
                case "name":
                    user.setName(value);
                    break;
                case "password":
                    String hashedPassword = PasswordUtil.hashPassword(value);
                    user.setPassword(hashedPassword);
                    break;
                case "createdAt":
                    user.setCreatedAt(value);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid attribute: " + attribute);
            }
            return user;
        }
        return null;
    }

    // Método para eliminar un usuario por su ID
    public boolean deleteById(int id) {
        return users.removeIf(user -> user.getId() == id);
    }
}