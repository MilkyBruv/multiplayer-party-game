using System.Numerics;
using Raylib_cs;

class Scene
{
	// TODO: Don't make a new camera for every scene
	protected Camera2D camera;

	// TODO: Make it so that the scene needs to have all methods
	public virtual void Start()
	{
		// Initialize the camera
		camera = new Camera2D()
		{
			Target = Vector2.Zero,
			Offset = Vector2.Zero,
			Rotation = 0f,
			Zoom = 1f
		};
	}

	public virtual void Update() { }

	public virtual void Render() { }

	public virtual void CleanUp() { }
}