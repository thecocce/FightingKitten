package Objects.World.MVC;

import DB.StringRes.MySettings;
import Objects.Environment.AddButton.MVC.AddButtonController;
import Objects.Kitten.MVC.KittenController;
import Objects.Monster.MVC.MonsterController;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class WorldController implements PropertyChangeListener
{
    private WorldModel worldModel;
    private WorldView worldView;

    public WorldController()
    {
        createStructure();
        setInputSources();

        drawDefaults();
    }

    private void createStructure()
    {
        worldModel = new WorldModel();
        worldView = new WorldView(this);

        worldModel.addObserver(worldView);
    }

    private void setInputSources()
    {
        InputMultiplexer inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(worldView);
        Gdx.input.setInputProcessor(inputMultiplexer);
    }

    private void drawDefaults()
    {
        new AddButtonController(this, new Vector2(0, 0));
        MonsterController monster = new MonsterController(this, new Vector2(500, 450));
        KittenController kitten = new KittenController(this, new Vector2(50, 150));

        monster.changeTarget(kitten.model);
    }

    public void addButtonClicked()
    {
        new KittenController(this, new Vector2(50, 450));
    }

    public void render(float delta)
    {
        Gdx.gl.glClearColor(0 / 2.55f, 0 / 2.55f, 0 / 2.55f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        updateAI(delta);
        updateView(delta);

        worldView.draw();
    }

    private void updateView(float delta)
    {
        worldView.act(delta);
    }

    private void updateAI(float delta)
    {
        worldModel.updateAI(delta);
    }

    public void resize()
    {
       worldView.resize();
    }

    public void dispose()
    {
        worldView.dispose();
        MySettings.ATLAS_DAO.getAtlasDAO().dispose();
    }

    public WorldModel getModel()
    {
        return worldModel;
    }
    public WorldView getView()
    {
        return worldView;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {}
}
