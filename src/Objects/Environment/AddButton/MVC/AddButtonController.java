package Objects.Environment.AddButton.MVC;

import Objects.Environment.AddButton.DTO.ButtonDTOs;
import Objects.World.MVC.WorldController;
import com.badlogic.gdx.math.Vector2;

public class AddButtonController
{
    private WorldController worldController;

    public AddButtonController(WorldController worldController)
    {
        this.worldController = worldController;
    }

    public void createButton(int x, int y)
    {
        AddButtonModel model = createModel(new Vector2(x, y));
        AddButtonView view = createView(model);
        AddToWorld(model, view);
    }

    private AddButtonModel createModel(Vector2 position)
    {
        return new AddButtonModel(position);
    }

    private AddButtonView createView(AddButtonModel model)
    {
        return new AddButtonView(this, model);
    }

    private void AddToWorld(AddButtonModel model, AddButtonView view)
    {
        ButtonDTOs.ButtonDTO k = new ButtonDTOs.ButtonDTO(model, view);
        worldController.getModel().addMob(k);
    }


    public void buttonClicked()
    {
        worldController.addButtonClicked();
    }
}
