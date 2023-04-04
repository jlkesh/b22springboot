```java

@GetMapping("/users")
public ResponseEntity<PagedModel<EntityModel<User>>>getUsers(Pageable pageable,PagedResourcesAssembler<User> assembler){
        Page<User> usersPage=userService.getUsers(pageable);
        PagedModel<EntityModel<User>>pagedModel=assembler.toModel(usersPage,new UserModelAssembler());
        return ResponseEntity.ok(pagedModel);
        }
```

```
public class UserModelAssembler implements RepresentationModelAssembler<User, EntityModel<User>> {
    @Override
    public EntityModel<User> toModel(User user) {
        return EntityModel.of(user,
                linkTo(methodOn(UserController.class).getUser(user.getId())).withSelfRel(),
                linkTo(methodOn(UserController.class).getUsers(Pageable.unpaged(), null)).withRel("users"));
    }
}
```








-
-
-
-
-
-
-
-
-
-
-
-
-
-
-
-
-
-







```
@Configuration
public class HateoasConfig {
    @Bean
    public PagedResourcesAssembler<User> userPagedResourcesAssembler() {
        return new PagedResourcesAssembler<>(new HateoasPageableHandlerMethodArgumentResolver(), null);
    }
}
```