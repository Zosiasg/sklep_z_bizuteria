package com.zosiasg.shop.controller;

import com.zosiasg.shop.model.Item;
import com.zosiasg.shop.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ItemController {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("ItemIndex")
    public String showItemsList(Model model) {
        model.addAttribute("items", itemRepository.findAll());
        return "adminview/ItemIndex";
    }

    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable("id") long id, Model model) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Item Id:" + id));
        itemRepository.delete(item);
        return "redirect:/ItemIndex";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Item Id:" + id));
        model.addAttribute("item", item);

        return "adminview/updateItem";
    }

    @PostMapping("/update/{id}")
    public String updateItem(@PathVariable("id") long id, @Valid Item item,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            item.setId(id);
            return "adminview/updateItem";
        }

        itemRepository.save(item);
        return "redirect:/ItemIndex";
    }
}