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

    @SuppressWarnings("unchecked")
    @Override
    public Set<Product> getProductSet() {
        Set<Product> productSet = new HashSet<>();
        productRepository.findAll().iterator().forEachRemaining(productSet::add);
        return productSet;
    }

    @Override
    public List<Product> getProductAsecPrice(){
        List<Product> productList = new ArrayList<>();
        productRepository.findAll().iterator().forEachRemaining(productList::add);
        Collections.sort(productList, new AlphaNumericComparatorAsec());
        return productList;
    }

    @Override
    public List<Product> getProductDescPrice(){
        List<Product> productList = new ArrayList<>();
        productRepository.findAll().iterator().forEachRemaining(productList::add);
        Collections.sort(productList, new AlphaNumericComparatorDesc());
        return productList;
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<Product> getProductsAsce() {
        List<Product> productList = new ArrayList<>();
        productRepository.findAll().iterator().forEachRemaining(productList::add);

        Collections.sort(productList, new LexicographicComparator());
        return productList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Product> getProductsDesc() {

        List<Product> productList = new ArrayList<>();
        productRepository.findAll().iterator().forEachRemaining(productList::add);

        Collections.sort(productList, new LexicographicComparatorReverse());
        return productList;
    }

    @SuppressWarnings("unchecked")
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
    public Product saveProduct(Product product) {
        productRepository.save(product);
        return product;
    }


    @Override
    public void deleteById(Long idToDelete) {
        productRepository.deleteById(idToDelete);
    }


    class AlphaNumericComparatorAsec implements Comparator<Product>
    {
        @Override
        public int compare(Product o1, Product o2) {
            if(o1.getProductPrice() == o2.getProductPrice())
            {
                return 0;
            }else if(o1.getProductPrice() < o2.getProductPrice()){
                return -1;
            }
            return 1;
        }
    }

    class AlphaNumericComparatorDesc implements Comparator<Product>
    {
        @Override
        public int compare(Product o1, Product o2) {
            if(o1.getProductPrice() == o2.getProductPrice())
            {
                return 0;
            }else if(o1.getProductPrice() < o2.getProductPrice()){
                return 1;
            }
            return -1;
        }
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
