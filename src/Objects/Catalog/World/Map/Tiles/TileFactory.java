package Objects.Catalog.World.Map.Tiles;

import DB.StringRes.MySettings;
import com.badlogic.gdx.math.Vector2;

public enum TileFactory {
    COLLECTION()
    {
        @Override public TileController grass(Vector2 position)
        {
            return new TileController(position, false, MySettings.ATLAS_DAO.getAtlasDAO().getTexture(MySettings.GROUND));
        }

        @Override public TileController wall(Vector2 position)
        {
            return new TileController(position, true, MySettings.ATLAS_DAO.getAtlasDAO().getTexture(MySettings.WALL));
        }
    };

    public abstract TileController grass(Vector2 position);
    public abstract TileController wall(Vector2 position);

    TileFactory() {}
}
