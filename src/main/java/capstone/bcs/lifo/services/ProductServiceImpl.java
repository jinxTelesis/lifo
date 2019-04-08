package capstone.bcs.lifo.services;


import capstone.bcs.lifo.Exceptions.NotFoundException;
import capstone.bcs.lifo.model.Product;
import capstone.bcs.lifo.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }

    @Override
    public List<Product> getProducts() {
        //Set<Product> productSet = new HashSet<>(); // prob needs to be a list
        List<Product> productList = new ArrayList<>();
        productRepository.findAll().iterator().forEachRemaining(productList::add);
        return productList;
        //productRepository.findAll().iterator().forEachRemaining(productSet::add);
        //return productSet;
    }


    @Override
    public Product findById(Long l) {

        Optional<Product> productOptional = productRepository.findById(l);

        if (!productOptional.isPresent()) {
            throw new NotFoundException();
        }

        return productOptional.get();
    }

    @Override
    public Set<Product> getProductSet() {
        Set<Product> productSet = new HashSet<>();
        productRepository.findAll().iterator().forEachRemaining(productSet::add);
        return productSet;
    }

    @Override
    public List<Product> getProductsAsce() {
        List<Product> productList = new ArrayList<>();
        productRepository.findAll().iterator().forEachRemaining(productList::add);

        Collections.sort(productList, new LexicographicComparator());
        return productList;
    }

    @SuppressWarnings("1")
    @Override
    public List<Product> getProductsDesc() {

        List<Product> productList = new ArrayList<>();
        productRepository.findAll().iterator().forEachRemaining(productList::add);

        Collections.sort(productList, new LexicographicComparatorReverse());
        return productList;
    }

    @Override
    public List<Product> getProductsByCategory(Integer integerPara) {
        List<Product> productList = new ArrayList<>();
        productRepository.findAll().iterator().forEachRemaining(productList::add);

        Iterator<Product> iterator = productList.iterator();

        List<Product> results = new ArrayList<>();
        while(iterator.hasNext())
        {
            Product value = iterator.next();
            if(integerPara.equals(value.getProductCat()))
            {
                results.add(value);
            }
        }

        return results;
}


    @Override
    public void deleteById(Long idToDelete) {
        productRepository.deleteById(idToDelete);
    }




    class LexicographicComparator implements Comparator<Product>
    {
        @Override
        public int compare(Product o1, Product o2) {
            return  o1.getProductName().compareToIgnoreCase(o2.getProductName());
        }
    }

    class LexicographicComparatorReverse implements Comparator<Product>
    {
        @Override
        public int compare(Product o1, Product o2) {
            int value = 0;
            value = o1.getProductName().compareToIgnoreCase(o2.getProductName());
            value = value*-1;
            return value;
        }
    }
}
