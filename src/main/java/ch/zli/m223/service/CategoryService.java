/* 
package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.*;

@ApplicationScoped
public class CategoryService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public Entry createCategory(Category category) {
        entityManager.persist(category);
        return category;
    }

    @Transactional
    public void editCategory(Long id, Category category) {
        Category newCategory = findById(id);
        NewCategory.setTitle(category.getTitle());
        entityManager.merge(newCategory);
    }

    @Transactional
    public void deleteCategory(Long id) {
        entityManager.remove(findById(id));
    }

    public List<Entry> findAll() {
        var query = entityManager.createQuery("FROM Category", Category.class);
        return query.getResultList();
    }

    public Entry findById(Long id) {
        return entityManager.find(Category.class, id);
    }
}
*/
