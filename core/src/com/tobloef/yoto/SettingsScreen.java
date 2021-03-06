package com.tobloef.yoto;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import de.tomgrill.gdxdialogs.core.dialogs.GDXButtonDialog;
import de.tomgrill.gdxdialogs.core.listener.ButtonClickListener;

public class SettingsScreen implements Screen {
    private final YouOnlyTapOnce game;
    private BitmapFont bigFont;
    private BitmapFont mediumFont;
    private BitmapFont smallFont;
    private Texture backTexture;
    private Texture backTexturePressed;
    private Texture muteTexture;
    private Texture muteTexturePressed;
    private Texture unmuteTexture;
    private Texture unmuteTexturePressed;
    private Texture resetTexture;
    private Texture resetTexturePressed;
    private Texture rateTexture;
    private Texture rateTexturePressed;
    private Texture twitterTexture;
    private Texture twitterTexturePressed;
    private Texture contactTexture;
    private Texture contactTexturePressed;
    private Texture enableVibrationTexture;
    private Texture enableVibrationTexturePressed;
    private Texture disableVibrationTexture;
    private Texture disableVibrationTexturePressed;
    private Sound clickSound;

    private Stage stage;
    private Table table;
    private Label vibrationLabel;
    private Label muteLabel;

    private boolean doVibrate;
    private boolean isMuted;

    private ImageButtonStyle backButtonStyle;
    private ImageButtonStyle muteButtonStyle;
    private ImageButtonStyle unmuteButtonStyle;
    private ImageButtonStyle resetButtonStyle;
    private ImageButtonStyle rateButtonStyle;
    private ImageButtonStyle twitterButtonStyle;
    private ImageButtonStyle contactButtonStyle;
    private ImageButtonStyle enableVibrationButtonStyle;
    private ImageButtonStyle disableVibrationButtonStyle;
    private LabelStyle labelStyleBig;
    private LabelStyle labelStyleMedium;
    private LabelStyle labelStyleSmall;

    public SettingsScreen(final YouOnlyTapOnce game) {
        this.game = game;
    }

    @Override
    public void show() {
        isMuted = game.prefs.getBoolean("settingsMute");
        doVibrate = game.prefs.getBoolean("settingsVibrate");

        bigFont = game.manager.get("big_font.ttf", BitmapFont.class);
        mediumFont = game.manager.get("medium_font.ttf", BitmapFont.class);
        smallFont = game.manager.get("small_font.ttf", BitmapFont.class);
        backTexture = game.manager.get("back_icon.png", Texture.class);
        backTexturePressed = game.manager.get("back_icon_pressed.png", Texture.class);
        muteTexture = game.manager.get("mute_icon.png", Texture.class);
        muteTexturePressed = game.manager.get("mute_icon_pressed.png", Texture.class);
        unmuteTexture = game.manager.get("unmute_icon.png", Texture.class);
        unmuteTexturePressed = game.manager.get("unmute_icon_pressed.png", Texture.class);
        resetTexture = game.manager.get("restart_icon.png", Texture.class);
        resetTexturePressed = game.manager.get("restart_icon_pressed.png", Texture.class);
        rateTexture = game.manager.get("rate_icon.png", Texture.class);
        rateTexturePressed = game.manager.get("rate_icon_pressed.png", Texture.class);
        twitterTexture = game.manager.get("twitter_icon.png", Texture.class);
        twitterTexturePressed = game.manager.get("twitter_icon_pressed.png", Texture.class);
        contactTexture = game.manager.get("contact_icon.png", Texture.class);
        contactTexturePressed = game.manager.get("contact_icon_pressed.png", Texture.class);
        enableVibrationTexture = game.manager.get("enable_vibration_icon.png", Texture.class);
        enableVibrationTexturePressed = game.manager.get("enable_vibration_icon_pressed.png", Texture.class);
        disableVibrationTexture = game.manager.get("disable_vibration_icon.png", Texture.class);
        disableVibrationTexturePressed = game.manager.get("disable_vibration_icon_pressed.png", Texture.class);
        clickSound = game.manager.get("click.mp3", Sound.class);

        backTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        backTexturePressed.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        muteTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        muteTexturePressed.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        unmuteTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        unmuteTexturePressed.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        resetTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        resetTexturePressed.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        rateTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        rateTexturePressed.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        enableVibrationTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        enableVibrationTexturePressed.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        disableVibrationTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        disableVibrationTexturePressed.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        twitterTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        twitterTexturePressed.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        contactTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        contactTexturePressed.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        backButtonStyle = new ImageButtonStyle();
        backButtonStyle.imageUp = new TextureRegionDrawable(new TextureRegion(backTexture));
        backButtonStyle.imageDown = new TextureRegionDrawable(new TextureRegion(backTexturePressed));

        muteButtonStyle = new ImageButtonStyle();
        muteButtonStyle.imageUp = new TextureRegionDrawable(new TextureRegion(muteTexture));
        muteButtonStyle.imageDown = new TextureRegionDrawable(new TextureRegion(muteTexturePressed));

        unmuteButtonStyle = new ImageButtonStyle();
        unmuteButtonStyle.imageUp = new TextureRegionDrawable(new TextureRegion(unmuteTexture));
        unmuteButtonStyle.imageDown = new TextureRegionDrawable(new TextureRegion(unmuteTexturePressed));

        resetButtonStyle = new ImageButtonStyle();
        resetButtonStyle.imageUp = new TextureRegionDrawable(new TextureRegion(resetTexture));
        resetButtonStyle.imageDown = new TextureRegionDrawable(new TextureRegion(resetTexturePressed));

        rateButtonStyle = new ImageButtonStyle();
        rateButtonStyle.imageUp = new TextureRegionDrawable(new TextureRegion(rateTexture));
        rateButtonStyle.imageDown = new TextureRegionDrawable(new TextureRegion(rateTexturePressed));

        twitterButtonStyle = new ImageButtonStyle();
        twitterButtonStyle.imageUp = new TextureRegionDrawable(new TextureRegion(twitterTexture));
        twitterButtonStyle.imageDown = new TextureRegionDrawable(new TextureRegion(twitterTexturePressed));

        contactButtonStyle = new ImageButtonStyle();
        contactButtonStyle.imageUp = new TextureRegionDrawable(new TextureRegion(contactTexture));
        contactButtonStyle.imageDown = new TextureRegionDrawable(new TextureRegion(contactTexturePressed));

        enableVibrationButtonStyle = new ImageButtonStyle();
        enableVibrationButtonStyle.imageUp = new TextureRegionDrawable(new TextureRegion(enableVibrationTexture));
        enableVibrationButtonStyle.imageDown = new TextureRegionDrawable(new TextureRegion(enableVibrationTexturePressed));

        disableVibrationButtonStyle = new ImageButtonStyle();
        disableVibrationButtonStyle.imageUp = new TextureRegionDrawable(new TextureRegion(disableVibrationTexture));
        disableVibrationButtonStyle.imageDown = new TextureRegionDrawable(new TextureRegion(disableVibrationTexturePressed));

        labelStyleBig = new LabelStyle();
        labelStyleBig.font = bigFont;

        labelStyleMedium = new LabelStyle();
        labelStyleMedium.font = mediumFont;

        labelStyleSmall = new LabelStyle();
        labelStyleSmall.font = smallFont;

        stage = new Stage(new ScreenViewport());
        stage.addListener(new InputListener() {
            @Override
            public boolean keyDown(InputEvent event, int keycode) {
                if (keycode == Input.Keys.BACK || keycode == Input.Keys.BACKSPACE) {
                    if (!isMuted) {
                        clickSound.play();
                    }
                    if (doVibrate) {
                        Gdx.input.vibrate(25);
                    }
                    game.setScreen(new MainMenuScreen(game));
                }
                return true;
            }
        });
        Gdx.input.setInputProcessor(stage);
        Gdx.input.setCatchBackKey(true);

        ImageButton backButton = new ImageButton(backButtonStyle);
        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!isMuted) {
                    clickSound.play();
                }
                if (doVibrate) {
                    Gdx.input.vibrate(25);
                }
                game.setScreen(new MainMenuScreen(game));
            }
        });

        ImageButton resetButton = new ImageButton(resetButtonStyle);
        resetButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                GDXButtonDialog dialog = game.dialogs.newDialog(GDXButtonDialog.class);
                dialog.setTitle("Are you sure?");
                dialog.setMessage("Are you sure you want to reset all your progress? This cannot be undone.");

                dialog.setClickListener(new ButtonClickListener() {

                    @Override
                    public void click(int button) {
                        if (button == 0) {
                            game.prefs.putInteger("levelsAvailable", 0);
                            game.prefs.flush();
                        }
                    }
                });

                dialog.addButton("Yes");
                dialog.addButton("No");

                dialog.build().show();
            }
        });
        Label resetLabel = new Label("Reset\nProgress", labelStyleSmall);
        resetLabel.setAlignment(2);

        ImageButton rateButton = new ImageButton(rateButtonStyle);
        rateButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!isMuted) {
                    clickSound.play();
                }
                if (doVibrate) {
                    Gdx.input.vibrate(25);
                }
                Gdx.net.openURI("https://play.google.com/store/apps/details?id=com.tobloef.yoto.android");
            }
        });
        Label rateLabel = new Label("Rate\n", labelStyleSmall);
        rateLabel.setAlignment(2);

        ImageButton twitterButton = new ImageButton(twitterButtonStyle);
        twitterButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!isMuted) {
                    clickSound.play();
                }
                if (doVibrate) {
                    Gdx.input.vibrate(25);
                }
                Gdx.net.openURI("https://twitter.com/tobloef");
            }
        });
        Label twitterLabel = new Label("Follow\n", labelStyleSmall);
        twitterLabel.setAlignment(2);

        ImageButton contactButton = new ImageButton(contactButtonStyle);
        contactButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!isMuted) {
                    clickSound.play();
                }
                if (doVibrate) {
                    Gdx.input.vibrate(25);
                }
                Gdx.net.openURI("mailto:tobloef@gmail.com?subject=You Only Tap Once");
            }
        });
        Label contactLabel = new Label("Feedback", labelStyleSmall);
        contactLabel.setAlignment(2);

        final ImageButton vibrationButton;
        if (game.prefs.getBoolean("settingsVibrate")) {
            vibrationButton = new ImageButton(disableVibrationButtonStyle);
            vibrationLabel = new Label("Disable\nVibration", labelStyleSmall);
        } else {
            vibrationButton = new ImageButton(enableVibrationButtonStyle);
            vibrationLabel = new Label("Enable\nVibration", labelStyleSmall);
        }
        vibrationButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!isMuted) {
                    clickSound.play();
                }
                if (game.prefs.getBoolean("settingsVibrate")) {
                    vibrationLabel.setText("Enable\nVibration");
                    vibrationButton.setStyle(enableVibrationButtonStyle);
                    game.prefs.putBoolean("settingsVibrate", false);
                    doVibrate = false;
                } else {
                    Gdx.input.vibrate(25);
                    vibrationLabel.setText("Disable\nVibration");
                    vibrationButton.setStyle(disableVibrationButtonStyle);
                    game.prefs.putBoolean("settingsVibrate", true);
                    doVibrate = true;
                }
                game.prefs.flush();
            }
        });
        vibrationLabel.setAlignment(2);

        final ImageButton muteButton;
        if (game.prefs.getBoolean("settingsMute")) {
            muteButton = new ImageButton(unmuteButtonStyle);
            muteLabel = new Label("Unmute\n", labelStyleSmall);
        } else {
            muteButton = new ImageButton(muteButtonStyle);
            muteLabel = new Label("Mute\n", labelStyleSmall);
        }
        muteLabel.setAlignment(2);
        muteButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (doVibrate) {
                    Gdx.input.vibrate(25);
                }
                if (game.prefs.getBoolean("settingsMute")) {
                    clickSound.play();
                    muteLabel.setText("Mute\n");
                    muteButton.setStyle(muteButtonStyle);
                    game.prefs.putBoolean("settingsMute", false);
                    isMuted = false;
                } else {
                    muteLabel.setText("Unmute\n");
                    muteButton.setStyle(unmuteButtonStyle);
                    game.prefs.putBoolean("settingsMute", true);
                    isMuted = true;
                }
                game.prefs.flush();
            }
        });

        Label titleLabel = new Label("Settings", labelStyleMedium);

        table = new Table();
        table.setFillParent(true);

        table.add(backButton).height(225 * game.sizeModifier).width(225 * game.sizeModifier).padLeft(game.sizeModifier * 115).padTop(20 * game.sizeModifier).uniformX().colspan(2).expandX().left();
        table.add(titleLabel).uniformX().colspan(2).expandX();
        table.add().uniformX().colspan(2).expandX();
        table.row();
        table.add(muteButton).size(game.sizeModifier * 250).padTop(50 * game.sizeModifier).padLeft(game.sizeModifier * 100).colspan(3);
        table.add(vibrationButton).size(game.sizeModifier * 250).padTop(50 * game.sizeModifier).colspan(3).padRight(game.sizeModifier * 100);
        table.row();
        table.add(muteLabel).expand().top().colspan(3).padLeft(game.sizeModifier * 100);
        table.add(vibrationLabel).expand().top().colspan(3).padRight(game.sizeModifier * 100);
        table.row();
        table.add(rateButton).size(game.sizeModifier * 250).colspan(3).padTop(game.sizeModifier * 150).padLeft(game.sizeModifier * 100);
        table.add(contactButton).size(game.sizeModifier * 250).colspan(3).padTop(game.sizeModifier * 150).padRight(game.sizeModifier * 100);
        table.row();
        table.add(rateLabel).expand().top().colspan(3).padLeft(game.sizeModifier * 100);
        table.add(contactLabel).expand().top().colspan(3).padRight(game.sizeModifier * 100);
        table.row();
        table.add(twitterButton).size(game.sizeModifier * 250).padTop(game.sizeModifier * 100).colspan(3).padLeft(game.sizeModifier * 100);
        table.add(resetButton).size(game.sizeModifier * 240).padTop(game.sizeModifier * 100).colspan(3).padRight(game.sizeModifier * 100);
        table.row();
        table.add(twitterLabel).expand().top().padBottom(game.sizeModifier * 200).colspan(3).padLeft(game.sizeModifier * 100);
        table.add(resetLabel).expand().top().padBottom(game.sizeModifier * 200).colspan(3).padRight(game.sizeModifier * 100);
        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(game.blue.r, game.blue.g, game.blue.b, 1);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
        game.sizeModifier = Math.min(width, height) / 1080f;
        show();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        bigFont.dispose();
        mediumFont.dispose();
        backTexture.dispose();
        backTexturePressed.dispose();
        muteTexture.dispose();
        muteTexturePressed.dispose();
        unmuteTexture.dispose();
        unmuteTexturePressed.dispose();
        resetTexture.dispose();
        resetTexturePressed.dispose();
        rateTexture.dispose();
        rateTexturePressed.dispose();
        enableVibrationTexture.dispose();
        enableVibrationTexturePressed.dispose();
        disableVibrationTexture.dispose();
        disableVibrationTexturePressed.dispose();
        clickSound.dispose();
    }
}
